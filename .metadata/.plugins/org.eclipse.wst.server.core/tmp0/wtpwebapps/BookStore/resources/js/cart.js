window.addEventListener("load", () => {
 
    document.querySelectorAll(".cart_update").forEach(item => {
        item.addEventListener("click", e =>{
            const tr = e.target.closest("tr");
            const input = tr.querySelector('input[name="amount"]');
            
            fetch(`/cart/update/${tr.dataset.bookid}/${input.value}`)
            .then(resp => resp.text())
            .then(result => {
                if(result == "OK") {
                    alert(`수량 변경 성공`);
                }
            });
        });
    });

    document.querySelectorAll('.cart_delete').forEach(item => {
        item.addEventListener('click', e => {
            const tr = e.target.closest('tr');
            
            fetch('/cart/delete/' + tr.dataset.bookid)
            .then(resp => resp.text())
            .then(result => {
                if(result == "OK") 
                    tr.remove();
            })

        })
    });

    document.querySelector('#check_all').addEventListener('change', e => {
        document.querySelectorAll('.check_item').forEach(item => {
            item.checked = e.target.checked;
        });
    });
    
    document.querySelector('#check_delete').addEventListener('click', e => {
        const list = [];
        document.querySelectorAll('.check_item:checked').forEach(item => {
            const bookid = item.closest('tr').dataset.bookid;
            list.push(parseInt(bookid));
        });

		if(list.length < 1) {
			alert("삭제를 원하시는 상품을 먼저 선택해주세요");
			return;
		}

		fetch("/cart/delete_check", {
            method:"POST",
            body: JSON.stringify(list),
            headers: {
                "Content-Type": "application/json",
            }
        }).then(resp => resp.text())
        .then(result => {
            if(result == "OK") {
                document.querySelectorAll('.check_item:checked').forEach(item => {
                    item.closest('tr').remove();
                });

            }
        });
    });

    document.querySelector('#update_all').addEventListener('click', e => {
        const list = [];

        document.querySelectorAll('input[name="amount"]').forEach(item => {
            const tr = item.closest('tr');
            
            if(item.value != item.dataset.value) {
                list.push({
                    bookid: parseInt(tr.dataset.bookid),
                    amount: parseInt(item.value),
                });
            }

        });
        if(list.length < 1) {
            alert("변경할 내용이 없습니다.");
            return;
        }

        fetch('/cart/update_all', {
            method:'POST',
            body:JSON.stringify(list),
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then(resp => resp.text())
        .then(result => {
            if(result == "OK") {
            	list.forEach(item => {
            		const tr = document.querySelector(`tr[data-bookid='${item.bookid}']`)
                    const input = tr.querySelector('input[name="amount"]');
                    const icon = tr.querySelector('i');

                    input.dataset.value = input.value;
                    icon.classList.add('hide');
            	});
                alert("모두 변경되었습니다");
            }
        })
    });

    document.querySelectorAll('input[name="amount"]').forEach(item => {
        item.addEventListener('change', e => {  
            const tr = e.target.closest('tr');
            const icon = tr.querySelector('i');

            if(e.target.dataset.value != e.target.value) {
                icon.classList.remove('hide');
            } else {
                icon.classList.add('hide');

            }
        });
    });
});
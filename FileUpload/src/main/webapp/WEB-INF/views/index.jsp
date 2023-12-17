<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>파일 업로드</title>
<script>
	const makeItem = (title, filename) => {
		const li = document.createElement('li');
	 	const div1 = document.createElement('div');
	 	div1.textContent = title;
	 	
	 	const div2 = document.createElement('div');
	 	const img = document.createElement('img');
	 	img.src = "upload/" + filename;
	 	
	 	li.append(div1);
	 	div2.append(img);
	 	li.append(div2);
	 	
	 	return li;
		
	};

	window.addEventListener("load", () => {
		document.querySelector('#ajax').addEventListener("click", e => {
			const item = new FormData();
			
			const title = document.querySelector("input[name='title']");
			const uploadFile = document.querySelector("input[name='uploadFile']");
			
			item.append("title", title.value);
			item.append("uploadFile", uploadFile.files[0]);
	
			fetch("upload/ajax", {
				method:'POST',
				body: item
			}).then(resp => resp.text())
			.then(result => {
				console.log(result);
				
				if(result == "OK"){
					
				 	document.querySelector('ul')
				 	.append(makeItem(title.value, uploadFile.files[0].name));
				}
			})
		});
	});
</script>
</head>
<body>
	<div>
		<div>
			<h3>이미지 갤러리</h3>
		</div>
		<div>
			<form action="upload" method="post" enctype="multipart/form-data">
				<div>
					<label>제목: </label> <input name="title" type="text">
				</div>
				<div>
					<label>파일: </label> <input name="uploadFile" type="file">
				</div>
				<div>
					<button>등록</button>
				</div>
			</form>
		</div>
		
		<div>
			<button id="ajax">AJAX 등록</button>
		</div>

		<hr>
		<div>
			<ul>
				<c:if test="${list.size() <1 }">
					<li>등록 된 이미지가 없습니다</li>
				</c:if>
				
				<c:forEach var="item" items="${list}">
					<li>
						<div>${item.title}</div>
						<div>
							<img alt="${item.title}" src="/kopo/upload/${item.filename}">
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>
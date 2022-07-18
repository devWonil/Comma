<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<style>
.star-rating {
	display: flex;
	flex-direction: row-reverse;
	font-size: 1.5em;
	justify-content: space-around;
	margin-left: 20px;
	text-align: center;
	width: 5em;
}

.star-rating input {
	display: none;
}

.star-rating label {
	color: transparent;
	text-shadow: 0 0 0 #e0e0e0;
	cursor: pointer;
}

.star-rating :checked ~ label {
	text-shadow: 0 0 0 #fdd826;
}

.star-rating label:hover, .star-rating label:hover ~ label {
	text-shadow: 0 0 0 #fdd826;
}
</style>
<br />
<br />
<div class="container">
	<h2>리뷰 등록</h2>
	<p>즐거운 여행 되셨나요?</p>
	<form>
		<!-- TODO 예약내역 뿌리기  -->
		<div class="form-group">
			<div class="form-group">
			<input type="hidden" value="" id="house-id">
				<label for="name"><b></b></label> <input type="text"
					class="form-control" id="name" disabled="disabled" />
			</div>
			<div class="form-group">
				<label for="name"><b> ~ </b></label> <input type="text"
					class="form-control" id="name" disabled="disabled" />
			</div>

			<label><b>만족도</b></label>
			<div class="form-group star-rating">
				<input type="radio" id="5-stars" name="rating" value="5" /> <label
					for="5-stars">⭐</label> <input type="radio" id="4-stars"
					name="rating" value="4" /> <label for="4-stars">⭐</label> <input
					type="radio" id="3-stars" name="rating" value="3" /> <label
					for="3-stars">⭐</label> <input type="radio" id="2-stars"
					name="rating" value="2" /> <label for="2-stars">⭐</label> <input
					type="radio" id="1-star" name="rating" value="1" /> <label
					for="1-star">⭐</label>
			</div>

			<div class="form-group summernote">
				<br /> <label for="content"><b></b></label>
				<textarea class="form-control" rows="10" id="content"
					placeHolder="숙소의 청결도, 위치, 호스트와의 의사소통에 대한 솔직한 후기를 남겨주세요."></textarea>
			</div>

		</div>
		<button type="button" onclick="postReview()" class="btn btn-primary"
			id="btn-save">등록</button>
	</form>
</div>
<script>

function postReview() {
	let starScore;
	let starLength = document.getElementsByName("rating").length;
	// let houseId = document.getElmentById("#house-id").value;
	  
     for (let i=0; i < starLength; i++) {
         if (document.getElementsByName("rating")[i].checked == true) {
             starScore = document.getElementsByName("rating")[i].value;
         }
     }

	let data = {
		content: document.querySelector("#content").value,
		starScore: starScore
	}
	// TODO houseId 넣어서 수정
	fetch("/review/post", {
		method: "post",
		headers: {
			'content-type': 'application/json; charset=utf-8'
		},
		body: JSON.stringify(data)
	})
	.then(res => {
			alert("리뷰 등록이 완료되었습니다.");
			location.href = "/";
	});
}

$(".custom-file-input").on(
		"change",
		function() {
			var fileName = $(this).val().split("\\").pop();
			$(this).siblings(".custom-file-label").addClass("selected")
					.html(fileName);
		});

$('.summernote').summernote({
	tabsize : 2,
	height : 300,
	toolbar : []
});
</script>
<%@ include file="../layout/footer.jsp"%>

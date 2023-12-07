function deleteMovie(n) {
	let ok = confirm('정말 삭제 합니까?');
	if (ok) {
		location.href =  'MovieDelC?nooo=' + n;
	}

}


function updateMovie(no, story, title, actor) {
	let title1 = prompt('수정할 제목?', title);
	let actor1 = prompt('수정할 배우?', actor);
	let story1 = prompt('수정할 줄거리?', story);

	location.href = "MovieUpdateC?t=" + title1 + "&a=" + actor1 + "&s=" + story1 + "&no=" + no;

} 
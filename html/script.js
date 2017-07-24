function toHome(){
	document.getElementById("about").style.display="none";
	document.getElementById("contact").style.display="none";
	document.getElementById("gallery").style.display="none";
	document.getElementById("home").style.display="block";
}
function toAbout(){
	document.getElementById("home").style.display="none";
	document.getElementById("contact").style.display="none";
	document.getElementById("gallery").style.display="none";
	document.getElementById("about").style.display="block";
}
function toContact(){
	document.getElementById("home").style.display="none";
	document.getElementById("about").style.display="none";
	document.getElementById("gallery").style.display="none";
	document.getElementById("contact").style.display="block";
}
function toGallery(){
	document.getElementById("home").style.display="none";
	document.getElementById("about").style.display="none";
	document.getElementById("contact").style.display="none";
	document.getElementById("gallery").style.display="block";
}
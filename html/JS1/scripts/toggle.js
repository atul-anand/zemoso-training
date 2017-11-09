document.getElementById("navHome").onclick = function toHome() {
	document.getElementById("about").style.display = "none";
	document.getElementById("contact").style.display = "none";
	document.getElementById("gallery").style.display = "none";
	document.getElementById("home").style.display = "block";
}
document.getElementById("navAbout").onclick = function toAbout() {
	document.getElementById("home").style.display = "none";
	document.getElementById("contact").style.display = "none";
	document.getElementById("gallery").style.display = "none";
	document.getElementById("about").style.display = "block";
}
document.getElementById("navContact").onclick = function toContact() {
	document.getElementById("home").style.display = "none";
	document.getElementById("about").style.display = "none";
	document.getElementById("gallery").style.display = "none";
	document.getElementById("contact").style.display = "block";
}
document.getElementById("navGallery").onclick = function toGallery() {
	document.getElementById("home").style.display = "none";
	document.getElementById("about").style.display = "none";
	document.getElementById("contact").style.display = "none";
	document.getElementById("gallery").style.display = "block";
}

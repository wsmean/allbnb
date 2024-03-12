function changeFn(){
		const floatingSelect  = document.getElementById("floatingSelect");
		const value = (floatingSelect.options[floatingSelect.selectedIndex].value);
		//alert("value = "+value);
		
		location.href="/hotelCountryInform.do?country_name="+value
};
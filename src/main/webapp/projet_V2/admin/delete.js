var x = document.getElementsByClassName("oui");
    var i;
    for (i = 0; i < x.length; i++) {  
      x[i].addEventListener("click", function(){
	  
    });
    }

      const myTimeout = setTimeout(time , 3000);

    function time() {
      document.querySelector(".delete").classList.add("d-none");
    }
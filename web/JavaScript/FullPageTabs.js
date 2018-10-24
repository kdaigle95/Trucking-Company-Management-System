/* 
 * author Andrea
 * 10/24/2018
 * https://www.w3schools.com/howto/howto_js_full_page_tabs.asp
 */


/* global pageName, color, elmnt */

function openPage(pageName, elmnt, color){
    //Hide all elements with class="tabcontent" by default
    var i, tabcontent, tablink;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++)
    {
        tabcontent[i].style.display = "none";
    }
    
    //Remove the background color of all tablinks/buttons
    tablink = document.getElementsByClassName("tablink");
    for ( i = 0; i < tablink.length; i++){
        tablink[i].style.backgroundColor = "";
    }
    
    //Show the specific tab content
    document.getElementById(pageName).style.display = "block";
    
    //Add the specific color to the butoon used to open the tab content
    elmnt.style.backgroundColor = color;
    
}

//Get the element with id="defualtOpen" and click on it
document.getElementById("defaultOpen").click();

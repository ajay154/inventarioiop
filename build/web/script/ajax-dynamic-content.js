var enableCache=true;var jsCache=new Array();var dynamicContent_ajaxObjects=new Array();function ajax_showContent(A,D,B){
    var C=document.getElementById(A);C.innerHTML=dynamicContent_ajaxObjects[D].response;if(enableCache){
        jsCache[B]=dynamicContent_ajaxObjects[D].response
        }dynamicContent_ajaxObjects[D]=false;ajax_parseJs(C)
    }function ajax_loadContent(A,B){
    if(enableCache&&jsCache[B]){
        document.getElementById(A).innerHTML=jsCache[B];return
    }var C=dynamicContent_ajaxObjects.length;document.getElementById(A).innerHTML='<table border=0 cellpadding=0 cellsapcing=0 width=100% height=100%><tr><td align=center><font face="tahoma" size="2" color="333333"><b>Loading content - please wait...</b></font></td></tr></table>';dynamicContent_ajaxObjects[C]=new sack();dynamicContent_ajaxObjects[C].requestFile=B;dynamicContent_ajaxObjects[C].onCompletion=function(){
        ajax_showContent(A,C,B)
        };dynamicContent_ajaxObjects[C].runAJAX()
    }function ajax_parseJs(F){
    var E=F.getElementsByTagName("SCRIPT");var B="";var D="";for(var G=0;G<E.length;G++){
        if(E[G].src){
            var C=document.getElementsByTagName("head")[0];var A=document.createElement("script");A.setAttribute("type","text/javascript");A.setAttribute("src",E[G].src)
            }else{
            if(navigator.userAgent.indexOf("Opera")>=0){
                D=D+E[G].text+"\n"
                }else{
                D=D+E[G].innerHTML
                }
            }
        }if(D){
        ajax_installScript(D)
        }
    }function ajax_installScript(A){
    if(!A){
        return
    }if(window.execScript){
        window.execScript(A)
        }else{
        if(window.jQuery&&jQuery.browser.safari){
            window.setTimeout(A,0)
            }else{
            window.setTimeout(A,0)
            }
        }
    };
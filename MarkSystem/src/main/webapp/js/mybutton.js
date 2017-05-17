//var allButtons = 26;           //总页数
//var startPage = 10;             //开始的页数
/**按钮自动生成 */
$(document).ready(function(){
    if(typeof(startPage) == "undefined"){
        initButton(1);
    }else{
        initButton(startPage);
    }
});
$(document).ready(function(){
    $(".btn-toolbar").click(function(){
            })
})
/**点击数字按钮 */
$(document).ready(function(){
    $(document).on("click",".btn-group.button.button-rounded.button-square",function(){
        if($(this).attr("page")==$(".btn-toolbar>.button-primary").attr("page")){
            return;
        }    
        $(".btn-toolbar>.button-primary").attr("class","btn-group button button-rounded button-square button-small btn-border");
        $(this).removeClass("btn-border");
        $(this).addClass("button-primary");
        preButtonControl();
        nextButtonControl();
        if(allButtons>9){
             buttonComposing();
        }
    });
    nextButtonClick();
    preButtonClick();   
});

/** 上一页按钮显示控制 */
function preButtonControl(){
    if($(".btn-toolbar>.button-primary").attr("page") ==  1){
        $(".pre").remove();
    }else{
        if($(".pre").length == 0){
            var preDiv = $("<a type='button' href='#' class='btn-group button button-rounded btn-border button-small pre' page='0000'>/a>").text("上一页");
            $(".btn-toolbar>.btn-group:first").before(preDiv);
        }
        $(".pre").attr("page",parseInt($(".btn-toolbar>.button-primary").attr("page"))-1);
    }
}
/** 上一页按钮点击控制 */
function preButtonClick(){
        $(document).on("click",".pre",function(){
        var btn = $(".button-square");
        for(var i=0;i<btn.length;i++){
            if($(btn[i]).attr("page")==$(".pre").attr("page")){
                $(btn)[i].click();
            }
        }
     });
}
/** 下一页按钮显示控制 */
function nextButtonControl(){
    if($(".btn-toolbar>.button-primary").attr("page") == allButtons){
         $(".next").remove();
    }else{
        if($(".next").length == 0){
            var nextDiv = $("<a type='button' href='#' class='btn-group button button-rounded btn-border button-small next' page='#'>/a>").text("下一页");
            $(".btn-toolbar>.btn-group:last").after(nextDiv);
        }
         $(".next").attr("page",parseInt($(".btn-toolbar>.button-primary").attr("page"))+1);
    }
}
/** 下一页按钮点击控制 */
function nextButtonClick(){
     $(document).on("click",".next",function(){
        var btn = $(".button-square");
        for(var i=btn.length-1;i>=0;i--){
           if($(btn[i]).attr("page") == $(".next").attr("page")){
               $(btn)[i].click();
           }
       }
     });
}

/** 按钮排版*/
function buttonComposing(){
    var currentPage = $(".btn-toolbar>.button-primary").attr("page");
    if(currentPage>=6 && currentPage<allButtons-3){
        createButton(currentPage);
        if(allButtons-currentPage==4){
            if($(".btn-toolbar>.btn-strong").length==2){
                $(".btn-toolbar>.btn-strong:last").remove();
            }
        }
    }
    if(currentPage<6){
        $(".btn-toolbar").children().remove();
        initButtonLessSix(currentPage);
    }
    if(allButtons-currentPage<4){
        if($(".btn-toolbar>.btn-strong").length==2){
            var differencePage = allButtons-currentPage;
            if(differencePage==4){

            }else if(differencePage==3){
                if($(".btn-toolbar>.button-primary").next().attr("page") != (allButtons-2)){   
                    var newDiv1 = $("<a type='button' href='#' class='btn-group button button-rounded button-square btn-border button-small' page="+(allButtons-2)+"></a>").text(allButtons-2);                    
                    $(".btn-toolbar>.btn-strong:last").before(newDiv1);
                    $($(".button-square")[1]).remove();
                }
                    var newDiv2 = $("<a type='button' href='#' class='btn-group button button-rounded button-square btn-border button-small' page="+(allButtons-1)+"></a>").text(allButtons-1);
                    $(".btn-toolbar>.btn-strong:last").before(newDiv2);
                    $($(".button-square")[1]).remove();
            }else if(differencePage==2){
                var newDiv = $("<a type='button' href='#' class='btn-group button button-rounded button-square btn-border button-small' page="+(allButtons-1)+"></a>").text(allButtons-1);
                $(".btn-toolbar>.btn-strong:last").before(newDiv);
                $($(".button-square")[1]).remove();
            }else if(differencePage==0){
                
            }
            $(".btn-toolbar>.btn-strong:last").remove();
        }
        if($(".btn-toolbar>.btn-strong").length==1){
            $(".btn-toolbar").children().remove();
            initButtonLastFour(currentPage);
        }
    }
}

/**中间按钮动态生成 */
function createButton(page){
            /**当按钮数是13个的时候 */
            if($(".btn-toolbar>.btn-strong").length==1 && allButtons-page==4){
                return;
            }
            if($(".btn-toolbar>.btn-strong").length==2){ 
                for(var i =3;i<10;i++){
                    $($(".btn-toolbar>.btn-group")[3]).remove();
                }
                 createMiddleButton(page);

            }else if($(".btn-toolbar>.btn-strong").length==1){       /**当按钮数是12个的时候 */
                if((page-1)>(allButtons-page)){             
                   var nextStrongDiv = $("<strong class='btn-group btn-strong'></strong>").text("...");  //生成... 
                   $($(".button-square")[7]).after(nextStrongDiv);  
                    $($(".button-square")[7]).remove();        
                 }else{
                    $($(".btn-toolbar>.btn-group")[2]).remove();         //移除第3个按钮
                    var preStrongDiv = $("<strong class='btn-group btn-strong'></strong>").text("...");  //生成...
                    $($(".btn-toolbar>.btn-group")[1]).after(preStrongDiv);
                }
                /*移除第4到9个按钮 */
                for(var i=3;i<9;i++){
                    $($(".btn-toolbar>.btn-group")[3]).remove();
                }
                createMiddleButton(page);
            }
}
/**生成中间按钮 */
function createMiddleButton(page){
                for(var i=page-3;i<parseInt(page)+4;i++){
                    var newDiv = $("<a type='button' href='#' class='btn-group button button-rounded button-square btn-border button-small' page="+i+"></a>").text(i);
                    if($(newDiv).attr("page") == page){
                        $(newDiv).attr("class","btn-group button button-rounded button-square button-small button-primary");
                    }
                    $(".btn-toolbar>.btn-strong:last").before(newDiv);
                }
}
/**初始化按钮 page选中的页数 */
function initButton(page){
        if(allButtons<10){
            initButtonLessTen(page);
        }else{
            if( page >=6 && (allButtons-page) >4){
                initButtonBigSix(page);
            }else if( page < 6){
                initButtonLessSix(page);
            }else if((allButtons-page)<=4){
                initButtonLastFour(page)
            }           
            if(page==1){
                $(".pre").remove();
            }else if(page==allButtons){
                $(".next").remove();
            }
        }
}
/**初始化按钮总数小于10个 */
function initButtonLessTen(page){
            var preDiv = $("<a type='button' href='#' class='btn-group button button-rounded btn-border button-small pre' page="+(page-1)+"></a>").text("上一页");
             $(".btn-toolbar").append(preDiv);
            for(var i=1;i<=allButtons;i++){
                    if(i==page){
                        var newDidv = $("<a type='button' href='#' class='btn-group button button-rounded button-square button-small button-primary' page="+i+"></a>").text(i);
                    }else{
                        var newDidv = $("<a type='button' href='#' class='btn-group button button-rounded button-square button-small btn-border' page="+i+"></a>").text(i);

                    }
                    $(".btn-toolbar").append(newDidv);
            }
            var nextDiv = $("<a type='button' href='#' class='btn-group button button-rounded btn-border button-small next' page="+(parseInt(page)+1)+"></a>").text("下一页");
            $(".btn-toolbar").append(nextDiv);      
            if(page==1){
                $(".pre").remove();
            }
            if(page==allButtons){
                $(".next").remove();
            }
}


function initButtonBigSix(page){
                var preDiv = $("<a type='button' href='#' class='btn-group button button-rounded btn-border button-small pre' page="+(page-1)+"></a>").text("上一页");
                var firstPageDiv = $("<a type='button' href='#' class='btn-group button button-rounded button-square button-small btn-border' page='1'></a>").text(1);
                $(".btn-toolbar").append(preDiv,firstPageDiv);            
                for(var i=(page-3);i<=(parseInt(page)+3);i++){
                        if(i==page){
                            var newDidv = $("<a type='button' href='#' class='btn-group button button-rounded button-square button-small button-primary' page="+i+"></a>").text(i);
                        }else{
                            var newDidv = $("<a type='button' href='#' class='btn-group button button-rounded button-square button-small btn-border' page="+i+"></a>").text(i);
                        }
                        $(".btn-toolbar").append(newDidv);
                }
                var firstStrongDiv = $("<strong class='btn-group btn-strong'></strong>").text("...");
                $(".button-square:first").after(firstStrongDiv);
                var lastStrongDiv = $("<strong class='btn-group btn-strong'></strong>").text("...");
                $(".button-square:last").after(lastStrongDiv);
                var endPageDiv = $("<a type='button' href='#' class='btn-group button button-rounded button-square button-small btn-border' page="+allButtons+"></a>").text(allButtons);
                var nextDiv = $("<a type='button' href='#' class='btn-group button button-rounded btn-border button-small next' page="+(parseInt(page)+1)+"></a>").text("下一页");
                $(".btn-toolbar").append(endPageDiv,nextDiv);
}

function initButtonLessSix(page){
            var preDiv = $("<a type='button' href='#' class='btn-group button button-rounded btn-border button-small pre' page="+(page-1)+"></a>").text("上一页");
             $(".btn-toolbar").append(preDiv);
            for(var i=1;i<=8;i++){
                    if(i==page){
                        var newDidv = $("<a type='button' href='#' class='btn-group button button-rounded button-square button-small button-primary' page="+i+"></a>").text(i);
                    }else{
                        var newDidv = $("<a type='button' href='#' class='btn-group button button-rounded button-square button-small btn-border' page="+i+"></a>").text(i);

                    }
                    $(".btn-toolbar").append(newDidv);
            }
            var lastStrongDiv = $("<strong class='btn-group btn-strong'></strong>").text("...");
            var endPageDiv = $("<a type='button' href='#' class='btn-group button button-rounded button-square button-small btn-border' page="+allButtons+"></a>").text(allButtons);
            var nextDiv = $("<a type='button' href='#' class='btn-group button button-rounded btn-border button-small next' page="+(parseInt(page)+1)+"></a>").text("下一页");
            $(".btn-toolbar").append(lastStrongDiv,endPageDiv,nextDiv);      
            if(page==1){
                $(".pre").remove();
            }
}

function initButtonLastFour(page){ 
            var preDiv = $("<a type='button' href='#' class='btn-group button button-rounded btn-border button-small pre' page="+(page-1)+"></a>").text("上一页");
            var firstPageDiv = $("<a type='button' href='#' class='btn-group button button-rounded button-square button-small btn-border' page='1'></a>").text(1);
             var lastStrongDiv = $("<strong class='btn-group btn-strong'></strong>").text("...");
             $(".btn-toolbar").append(preDiv,firstPageDiv,lastStrongDiv);
            for(var i=(allButtons-7);i<=allButtons;i++){
                    if(i==page){
                        var newDidv = $("<a type='button' href='#' class='btn-group button button-rounded button-square button-small button-primary' page="+i+"></a>").text(i);
                    }else{
                        var newDidv = $("<a type='button' href='#' class='btn-group button button-rounded button-square button-small btn-border' page="+i+"></a>").text(i);

                    }
                    $(".btn-toolbar").append(newDidv);
            }         
            var nextDiv = $("<a type='button' href='#' class='btn-group button button-rounded btn-border button-small next' page="+(parseInt(page)+1)+"></a>").text("下一页");
            $(".btn-toolbar").append(nextDiv);      
            if(page==allButtons){
                $(".next").remove();
            }
}
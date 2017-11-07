/**
 * Created by ren on 2017/11/7.
 */
$(function () {
  $(".header_select_province dt").hover(function () {
    $(".header_select_province dt").css("background","#f2f2f2")
  });
  $(".head_right dl").hover(function(){
    $(this).addClass("navactive");
    $(this).find("dd").show();
    $(this).prev().find("p").css("right","-2px");
  },function(){
    $(".head_right dl").removeClass("navactive");
    $(".head_right dd").hide();
    $(this).prev().find("p").css("right","-1px");
  })
})
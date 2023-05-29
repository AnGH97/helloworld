$(".all_check").on("change", (e) => {
    $(".check").prop("checked", $(e.currentTarget).prop("checked"));
});

//수량 증감

let cnt_number = document.querySelector(".count_number");
//let result1 = document.querySelector(".price0-money");
//let sprice = document.querySelector(".sale-price");
let i = 1;

$(".count_up").on("click", (e) => {
    i++;
    cnt_number.textContent = i;
});
$(".count_down").on("click", (e) => {
    if(i > 1){
        i--;
        cnt_number.textContent = i;
    }
});

//선택 삭제

$(".choice-del").on("click", (e) => {
    if($("input:checkbox[class='check']:checked").length === 0){
        alert("삭제할 항목을 선택해 주세요.");
        return;
    }
    $("input:checkbox[class='check']:checked").each(function(k, kVal){
        let a = kVal.parentElement.parentElement;
        $(a).remove();
    });
});

//전체 삭제

/*$(".all-del").on("click", (e) => {
    $("input:checkbox[class='check']").each(function(k, kVal){
        let a = kVal;
        console.log(kVal);
    });
});*/

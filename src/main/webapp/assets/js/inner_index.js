 $(".mcbt").on("click", (e) => {
    const target_id = $(e.currentTarget);
    console.log(target_id);
    $(target_id).css({
        "font-weight": "800",
        "color": "black"
    });
    $(".mcbt").not(e.currentTarget).css({
        "font-weight": "500",
        "color": "grey"
    })
});

$(".hover-img").on("mouseenter mouseleave", (e) => {
    const current = $(e.currentTarget);
    const tmp = current.attr("src");
    const over = current.data("over");
    current.attr("src", over);
    current.data("over", tmp);
});

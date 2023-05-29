$(".thumbnail").on("click", (e) => {
    const img = $(e.currentTarget).attr('src');
    $("#target").attr('src', img);
});

$(".bt").on("click", (e) => {
    const target_id = $(e.currentTarget);
    console.log(target_id);
    $(target_id).css({
        "color": "grey",
        "font-weight": "600"
    });
    $(".bt").not(e.currentTarget).css({
        "color": "#d5d5d5",
        "font-weight": "500"
    })
});

$(".dmbt").on("click", (e) => {
    const target_id = $(e.currentTarget);
    console.log(target_id);
    $(target_id).css({
        "border-bottom" : "4px solid black"
    });
    $(".dmbt").not(e.currentTarget).css({
        "border-bottom" : "none"
    })
});

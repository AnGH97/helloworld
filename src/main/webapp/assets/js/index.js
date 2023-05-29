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

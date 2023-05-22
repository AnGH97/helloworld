$("#menu-open").on("click", (e) => {
    $("#entire-menu-id").show();
})

$("#menu-close").on("click", (e) => {
    $("#entire-menu-id").hide();
})


$("#search-open").on("click", (e) => {
    $("#main-search-form").show();
})

$("#search-close").on("click", (e) => {
    $("#main-search-form").hide();
})



$("#main-search-form").on("submit", (e) => {
    e.preventDefault();

    const searching = $("#main-search");
    if (!searching.val()) {
        alert("검색어를 입력하세요.");
        searching.focus();
        return false;
    }
});

$(document).ready(() => {
    $("#locales").change(() => {
        const selectedOption = $('#locales').val();
        if (selectedOption !== ''){
            let page = window.location.protocol + "//" + window.location.host + window.location.pathname;
            if(window.location.href.includes("product?")){
                const currentPage = window.location.href + "&lang=es";
                const params = currentPage.split("?")[1];
                const rParam = params.split("&")[0];
                page = page + "?" + rParam + "&lang=";
            }else {
                page = page + "?lang=";
            }
            window.location.replace(page + selectedOption);
        }
    });
});
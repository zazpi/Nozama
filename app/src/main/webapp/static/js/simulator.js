$(document).ready(() => {
    let rb = null;
    let selector = null;
    const moveRobots = (robotsData) => {
        robotsData.map((data) => {
            console.log(data);
            $("#rb" + data.id).remove();
            id = "#" + data.row + data.num;
            if ((data.row == "B") && (data.num < 4)) 
            	$(id).css('left', data.pos+'%');
            else if (data.row == "B") $(id).css('padding-left', data.pos+'%');
            else if (data.row == "A") $(id).css('right', data.pos+'%');
            else if ((data.row == "AB") && (data.num % 2 == 0)) $(id).css('top', data.pos+'%');
            else $(id).css('bottom', data.pos+'%');
            $(id).append("<span id='rb" + data.id + "'" + " class='dot'></span>");
        });
    };
    const getProductsData = async () => {
        try {
            const result = await fetch("http://app-nozama.duckdns.org:4567/rb-data");
            const data = await result.json();
            moveRobots(data);
        }catch (error) {
            return "Unable to load products.";
        }

        setTimeout(getProductsData, 25);
    };

    getProductsData();
});
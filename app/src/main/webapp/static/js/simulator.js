const moveRobots = () => {
    $("#robot-1").css({marginLeft: '+=1px'});
    $("#robot-2").css({marginLeft: '+=1px'});
    $("#robot-3").css({marginLeft: '+=1px'});
    $("#robot-4").css({marginLeft: '+=1px'});
    $("#robot-5").css({marginLeft: '+=1px'});
    setTimeout(moveRobots, 100);
};

moveRobots();
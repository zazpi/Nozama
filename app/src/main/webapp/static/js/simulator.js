$(document).ready(() => {
    /*const moveRobots = () => {
        $("#robot-1").css({marginLeft: '+=1px'});
        $("#robot-2").css({marginLeft: '+=1px'});
        $("#robot-3").css({marginLeft: '+=1px'});
        $("#robot-4").css({marginLeft: '+=1px'});
        $("#robot-5").css({marginLeft: '+=1px'});
        setTimeout(moveRobots, 100);
    };

    moveRobots();*/
    const spanEl1 = $("<span id='robot-1'>").addClass( "dot");
    const spanEl2 = $("<span id='robot-2'>").addClass( "dot");
    const spanEl3 = $("<span id='robot-3'>").addClass( "dot");
    const spanEl4 = $("<span id='robot-4'>").addClass( "dot");
    const spanEl5 = $("<span id='robot-5'>").addClass( "dot");

    const moveRobots = () => {
      $("#AW-3").append(spanEl1);
      $("#AW-2").append(spanEl3);
      $("#AW-1").append(spanEl2);
      $("#BW-4").append(spanEl5);
      $("#BW-5").append(spanEl4);
      $("#BW-6").append(spanEl1);
    };
    const moveRobots2 = () => {
        $("#AW-3").append(spanEl4);
        $("#AW-2").append(spanEl5);
        $("#AW-1").append(spanEl3);
        $("#BW-4").append(spanEl2);
        $("#BW-5").append(spanEl1);
        $("#BW-6").append(spanEl5);
        setTimeout(moveRobots, 2000);
        setTimeout(moveRobots2, 3000);
    };
    setTimeout(moveRobots, 2000);
    setTimeout(moveRobots2, 3000);

});
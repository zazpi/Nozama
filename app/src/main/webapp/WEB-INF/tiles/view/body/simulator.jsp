<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="/static/css/simulator.css">
<fmt:bundle basename="resources.View">
<section class="simulator">
    <header>
        <h2>Simulator</h2>
    </header>
    <div>
        <p>Something is supposed to happen here</p>
        <span id="robot-1" class="dot"></span>
        <span id="robot-2" class="dot"></span>
        <span id="robot-3" class="dot"></span>
        <span id="robot-4" class="dot"></span>
        <span id="robot-5" class="dot"></span>
    </div>
</section>
</fmt:bundle>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/simulator.js"></script>
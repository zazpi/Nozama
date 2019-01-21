<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="/static/css/simulator.css">
<section class="simulator">
    <header>
        <h2><fmt:message key="simulator.pageName"/></h2>
    </header>
    <div class="workstation-container">
        <header>
            <h3><fmt:message key="simulator.subTitle"/></h3>
        </header>
        <div class="workstation-grid">
            <div class="workpark-posts">
                <div id="AW0" class="wp-position wp-position__workstation">
                </div>
                <div id="AP0" class="wp-position wp-position__parking">
                </div>
                <div id="AW1" class="wp-position wp-position__workstation">
                </div>
                <div id="AP1" class="wp-position wp-position__parking">
                </div>
                <div id="AW2" class="wp-position wp-position__workstation">
                </div>
            </div>
            <div class="workstations">
                <div id="workstation-1" class="workstation">
                    <div id="AB0" class="v-rows"></div>
                    <div id="A0" class="rows"></div>
                    <div id="B0" class="rows"></div>

                </div>
                <div id="workstation-2" class="workstation">
                    <div id="AB1" class="v-rows"></div>
                    <div id="A1" class="rows"></div>
                    <div id="B1" class="rows"></div>

                </div>
                <div id="workstation-3" class="workstation">
                    <div id="AB2" class="v-rows"></div>
                    <div id="A2" class="rows"></div>
                    <div id="B2" class="rows"></div>

                </div>
                <div id="workstation-4" class="workstation">
                    <div id="AB3" class="v-rows"></div>
                    <div id="A3" class="rows"></div>
                    <div id="B3" class="rows"></div>
                </div>
                <div id="workstation-5" class="workstation">
                    <div id="A4" class="rows"></div>
                    <div id="B4" class="rows"></div>
                    <div id="AB4" class="v-rows"></div>
                    <div id="AB5" class="v-rows"></div>
                </div>
            </div>
            <div class="workpark-posts">
                <div id="BW0" class="wp-position wp-position__workstation">
                </div>
                <div id="BP0" class="wp-position wp-position__parking">
                </div>
                <div id="BW1" class="wp-position wp-position__workstation">
                </div>
                <div id="BP2" class="wp-position wp-position__parking">
                </div>
                <div id="BW2" class="wp-position wp-position__workstation">
                </div>
            </div>
        </div>
    </div>
    <div class="legend">
        <header>
            <h3><span><fmt:message key="simulator.info"/></span></h3>
        </header>
        <div class="legend-flex">
            <div>
                <header>
                    <h4><span><fmt:message key="simulator.pos"/></span></h4>
                </header>
                <ul>
                    <li><p><fmt:message key="simulator.work"/><b class="legend__workstation"></b></p></li>
                    <li><p><fmt:message key="simulator.park"/><b class="legend__parking"></b></p></li>
                </ul>
            </div>
            <div>
                <header>
                    <h4><span><fmt:message key="simulator.robot"/></span></h4>
                </header>
                <ul class="robots-grid">
                    <li><p>Robot 1: <b id="l-rb0" class="legend__robot"></b></p></li>
                    <li><p>Robot 2: <b id="l-rb1" class="legend__robot"></b></p></li>
                    <li><p>Robot 3: <b id="l-rb2" class="legend__robot"></b></p></li>
                    <li><p>Robot 4: <b id="l-rb3" class="legend__robot"></b></p></li>
                    <li><p>Robot 5: <b id="l-rb4" class="legend__robot"></b></p></li>
                </ul>
            </div>
        </div>
    </div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/simulator.js"></script>
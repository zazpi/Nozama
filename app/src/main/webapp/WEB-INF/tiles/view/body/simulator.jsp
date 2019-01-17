<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="/static/css/simulator.css">
<fmt:bundle basename="resources.View">
    <section class="simulator">
        <header>
            <h2>Simulator</h2>
        </header>
        <div class="workstation-container">
            <header>
                <h3>Workstations</h3>
            </header>
            <div class="workstation-grid">
                <div class="workpark-posts">
                    <div class="wp-position wp-position__workstation">
                    </div>
                    <div class="wp-position wp-position__parking">
                    </div>
                    <div class="wp-position wp-position__workstation">
                    </div>
                    <div class="wp-position wp-position__parking">
                    </div>
                    <div class="wp-position wp-position__workstation">
                    </div>
                </div>
                <div class="workstations">
                    <div id="workstation-1" class="workstation">
                        <div id="AW-3" class="rows"></div>
                        <div id="BW-4" class="rows"></div>
                    </div>
                    <div id="workstation-2" class="workstation">
                        <div id="AP-1" class="rows"></div>
                        <div id="BP-1" class="rows"></div>
                    </div>
                    <div id="workstation-3" class="workstation">
                        <div id="AW-2" class="rows"></div>
                        <div id="BW-5" class="rows"></div>
                    </div>
                    <div id="workstation-4" class="workstation">
                        <div id="AP-2" class="rows"></div>
                        <div id="BP-2" class="rows"></div>
                    </div>
                    <div id="workstation-5" class="workstation">
                        <div id="AW-1" class="rows"></div>
                        <div id="BW-6" class="rows"></div>
                    </div>
                </div>
                <div class="workpark-posts">
                    <div class="wp-position wp-position__workstation">
                    </div>
                    <div class="wp-position wp-position__parking">
                    </div>
                    <div class="wp-position wp-position__workstation">
                    </div>
                    <div class="wp-position wp-position__parking">
                    </div>
                    <div class="wp-position wp-position__workstation">
                    </div>
                </div>
            </div>
        </div>
        <div class="legend">
            <header>
                <h3><span>Classification</span></h3>
            </header>
            <div class="legend-flex">
                <div>
                    <header>
                        <h4><span>Positions:</span></h4>
                    </header>
                    <ul>
                        <li><p>Parking: <b class="legend__parking"></b></p></li>
                        <li><p>Workstation: <b class="legend__workstation"></b></p></li>
                    </ul>
                </div>
                <div>
                    <header>
                        <h4><span>Robots: </span></h4>
                    </header>
                    <ul class="robots-grid">
                        <li><p>Robot 1: <b class="legend__robot rb-1"></b></p></li>
                        <li><p>Robot 2: <b class="legend__robot rb-2"></b></p></li>
                        <li><p>Robot 3: <b class="legend__robot rb-3"></b></p></li>
                        <li><p>Robot 4: <b class="legend__robot rb-4"></b></p></li>
                        <li><p>Robot 5: <b class="legend__robot rb-5"></b></p></li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
</fmt:bundle>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/simulator.js"></script>
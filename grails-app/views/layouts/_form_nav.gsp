<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="inner_nav_title">
                <g:link controller="${controllerName}" action="index"><h2><i class="fa fa-bars"></i> List</h2></g:link>
                <g:link controller="${controllerName}" action="create"><h2><i class="fa fa-plus"></i> New</h2></g:link>
                <g:if test="${controllerName=='clientTanks'}">
                    <g:link controller="${controllerName}" action="uploadTanks"><h2><i class="fa fa-plus"></i>Upload Tanks</h2></g:link>
                </g:if>
            </div>
        </div>
    </div>
</div>

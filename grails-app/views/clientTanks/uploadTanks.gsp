<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'UpdateDriverAccount.label', default: 'UpdateDriverAccount')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">
        <g:render template="/layouts/form_nav"/>

        <div class="clearfix"></div>

        <div class="row">
            <g:if test="${errors}">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="alert alert-danger alert-dismissible fade in" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span>
                        </button>
                        <strong>File Error!</strong> make sure cells don't contain commas and the drivers have a space between their first and last name.
                    </div>
                </div>
            </g:if>

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Update Tanks</h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Settings 1</a>
                                    </li>
                                    <li><a href="#">Settings 2</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">

                        <g:uploadForm name="myUpload" url="[resource:tanks, action:'uploadTanksFile']" class="form-horizontal form-label-left">

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Upload CSV File</label>
                                <div class="col-md-9 col-sm-9 col-xs-12">

                                    <input class="" type="file" name="tanks" accept=".csv">
                                </div>
                            </div>
                            <div class="ln_solid"></div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input class="btn btn-success" type="submit" value="upload">
                                </div>
                            </div>

                        </g:uploadForm>

                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- /page content -->

</body>
</html>
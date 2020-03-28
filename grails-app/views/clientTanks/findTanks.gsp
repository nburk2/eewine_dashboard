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
                        <h2>Find Tanks</h2>
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

                        <g:form id="demo-form2" url="[action:'findTanks']" class="form-horizontal form-label-left">

                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Account</label>
                                    <g:select name="account" from="${dashboard.clientData.ClientAccounts.list([sort:"name"])}" class="select2_single form-control" optionValue="name" optionKey="id" value="${tank?.account?.id}" tabindex="-1"/>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">True False</label>
                                    <g:select name="booleanField" from="${trueFalseList}" class="select2_single form-control" value="${booleanField == "" ? 'none' : currentBooleanField}" tabindex="-1"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Choose Field</label>
                                    <g:select name="inputField" from="${inputFieldsList}" class="select2_single form-control" value="${inputField == "" ? 'none' : currentInputField}" tabindex="-1"/>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Field contains</label>
                                    <input type="text" id="inputFieldText" name="inputFieldText" value="" required="required" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>

                            <div class="form-group pull-right">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                        <g:submitButton name="create" type="submit" class="btn btn-success" value="Find Tanks"/>
                                </div>
                            </div>

                        </g:form>

                    </div>
                    %{--Tanks list--}%
                    <div class="x_content">

                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <g:sortableColumn class="idTables" property="id" title="Id"/>
                                <g:sortableColumn class="idTables" property="account.name" title="Account"/>
                                <g:sortableColumn class="idTables" property="number" title="Number"/>
                            </tr>
                            </thead>
                            <tbody>
                            <g:each in="${tanks}" var="tank">
                                <tr>
                                    <th scope="row"><g:link action="show" id="${tank.id}">${tank.id}</g:link></th>
                                    <th>${tank.account.name}</th>
                                    <th><g:link action="show" id="${tank.id}">${tank.number}</g:link></th>
                                </tr>
                            </g:each>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- /page content -->

</body>
</html>
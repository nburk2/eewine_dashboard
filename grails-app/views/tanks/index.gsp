<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tanks.label', default: 'Tanks')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <div class="right_col" role="main">
        <div class="">

            <g:render template="/layouts/form_nav"/>

            <div class="clearfix"></div>

            <div class="row">
                <g:if test="${error}">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="alert alert-danger alert-dismissible fade in" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span>
                            </button>
                            <strong>${error}</strong>
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

                            <g:form id="demo-form2" url="[action:'index']" class="form-horizontal form-label-left">

                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Account Number</label>
                                        <input type="text" id="accountNumber" name="accountNumber" value="" class="form-control col-md-7 col-xs-12">
                                    </div>
                                    <div class="col-md-3 col-sm-6 col-xs-12">
                                        <label style="visibility: hidden" class="control-label col-md-12 col-sm-12 col-xs-12">Account Number</label>
                                        <g:submitButton name="create" type="submit" class="btn btn-success form-control  col-md-7 col-xs-12" value="Find Tanks"/>
                                    </div>
                                </div>

                            </g:form>

                        </div>
                        %{--Tanks List--}%
                        <div class="x_content">

                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <g:sortableColumn class="idTables" property="id" title="Id"/>
                                    <g:sortableColumn class="idTables" property="account.name" title="Account Name"/>
                                    <g:sortableColumn class="idTables" property="tankNum" title="Tank Number"/>
                                </tr>
                                </thead>
                                <tbody>
                                <g:each in="${tanksList}" var="tank">
                                    <tr>
                                        <th scope="row">${tank.id}</th>
                                        <th><g:link action="show" id="${tank.id}">${tank.account.name}</g:link></th>
                                        <th><g:link action="show" id="${tank.id}">${tank.tankNum}</g:link></th>
                                    </tr>
                                </g:each>
                                </tbody>
                            </table>

                            <div class="dataTables_paginate paging_full_numbers">
                                <g:paginate class="pagination" next="next" prev="Previous"
                                            maxsteps="5" controller="tanks"
                                            action="index" total="${tanksCount}" />
                            </div>


                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    </body>
</html>
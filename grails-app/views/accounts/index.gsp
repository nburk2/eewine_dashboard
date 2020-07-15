<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'accounts.label', default: 'Accounts')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <!-- page content -->
    <div class="right_col" role="main">
        <div class="">

            <g:render template="/layouts/form_nav"/>

            <div class="clearfix"></div>

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Accounts</h2>
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

                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <g:sortableColumn class="idTables" property="id" title="Id"/>
                                    <g:sortableColumn class="idTables" property="name" title="Name"/>
                                </tr>
                                </thead>
                                <tbody>
                                <g:each in="${accountsList}" var="account">
                                    <tr>
                                        <th scope="row">${account.id}</th>
                                        <th><g:link action="show" id="${account.id}">${account.name}</g:link></th>
                                    </tr>
                                </g:each>
                                </tbody>
                            </table>
                            <div class="dataTables_paginate paging_full_numbers">
                                <g:paginate class="pagination" next="next" prev="Previous"
                                            maxsteps="5" controller="tanks"
                                            action="index" total="${accountsCount}" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    </body>
</html>
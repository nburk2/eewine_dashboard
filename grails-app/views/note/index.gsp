<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'note.label', default: 'Note')}" />
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
                                <h2>Notes</h2>
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
                                        <g:sortableColumn class="idTables" property="message" title="Message"/>
                                        <g:sortableColumn class="idTables" property="messageType" title="Type"/>
                                        <g:sortableColumn class="idTables" property="useFrom" title="From"/>
                                        <g:sortableColumn class="idTables" property="useTo" title="To"/>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <g:each in="${noteList}" var="note">
                                        <tr>
                                            <th scope="row">${note.id}</th>
                                            <th><g:link action="show" id="${note.id}">${note.message}</g:link></th>
                                            <th>${note.messageType}</th>
                                            <th>${note.useFrom}</th>
                                            <th>${note.useTo}</th>
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
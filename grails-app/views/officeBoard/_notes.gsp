<div class="x_panel">
    <div class="x_content">
        <p class="lead"><i class="fa fa-sticky-note"></i> Notes</p>
        <div class="table-responsive">
            <table class="table">
                <tbody>
                <g:each in="${noteList}" var="note">
                    <tr>
                        <g:if test="${note.messageType == dashboard.data.Note.MessageType.WARNING}">
                            <th class="dashboard text-warning lead" style="width:50%">${note.message}</th>
                        </g:if>
                        <g:elseif test="${note.messageType == dashboard.data.Note.MessageType.ERROR}">
                            <th class="dashboard text-danger lead" style="width:50%">${note.message}</th>
                        </g:elseif>
                        <g:elseif test="${note.messageType == dashboard.data.Note.MessageType.SUCCESS}">
                            <th class="dashboard text-success lead" style="width:50%">${note.message}</th>
                        </g:elseif>
                        <g:else>
                            <th class="dashboard text-primary lead" style="width:50%">${note.message}</th>
                        </g:else>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>
</div>
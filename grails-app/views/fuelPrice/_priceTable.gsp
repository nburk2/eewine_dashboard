<%@ page import="java.math.RoundingMode; java.math.MathContext" %>
<div class="grid-masonry">
    <g:each status="i" in="${fuelPrices}" var="priceCategory">
        <div class="grid-item">
            <div class="x_content">
                <div class="x_title">
                    <h2>${priceCategory.name}</h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">

                    <table class="table">
                        <thead>
                        <tr>
                            %{--<th>${priceCategory.name}</th>--}%
                            <th>BPC</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Effective Date</th>
                        </tr>
                        </thead>
                        <tbody>
                            <g:each in="${priceCategory.rows}" var="row">
                                <tr>
                                    %{--<td></td>--}%
                                    <td>
                                        <b style="color:black">${row.bpc}</b>
                                    </td>
                                    <td>
                                        <b style="color:black">${row.description}</b>
                                    </td>
                                    <td>
                                        <b style="color:black">${row.price}</b>
                                        <g:if test="${row.difference?.toString()?.contains("-")}">
                                            <small class="text-danger"> ${row.difference}</small>
                                        </g:if>
                                        <g:elseif test="${row.difference?.toFloat() == 0 || !row.difference}">

                                        </g:elseif>
                                        <g:else>
                                            <small class="text-success"> +${row.difference}</small>
                                        </g:else>
                                    </td>
                                    <td>
                                        <b style="color:black">${row.effectiveDate}</b>
                                    </td>
                                </tr>
                            </g:each>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </g:each>
</div>

<style>
.grid-item {
    background: #fff;
    border: 1px solid #E6E9ED;
    width: 31%;
    margin:0 1% 5px;
    padding: 10px 10px 0px 10px;
    float: left;
    -webkit-column-break-inside: avoid;
    -moz-column-break-inside: avoid;
    column-break-inside: avoid;
    opacity: 1;
    display: inline-block;
}
@media only screen and (max-width: 960px) {
    .grid-item {
        background: #fff;
        border: 1px solid #E6E9ED;
        width: 100%;
        margin:0 1% 5px;
        padding: 10px 10px 0px 10px;
        float: left;
        -webkit-column-break-inside: avoid;
        -moz-column-break-inside: avoid;
        column-break-inside: avoid;
        opacity: 1;
        display: inline-block;
    }
}
</style>
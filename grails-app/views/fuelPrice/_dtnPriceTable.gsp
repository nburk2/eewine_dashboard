<%@ page import="java.math.RoundingMode; java.math.MathContext" %>
<div class="x_panel">
    <div class="x_content">
        <div class="x_title">
            <h2 class="3rem">DTN Prices - Today <small class="invisible">--</small></h2>
            <g:form action="fuelPrices">
                <g:datePicker id="priceDate" name="priceDate" precision="day" relativeYears="[-3..1]" value="${priceDate}"/>
                <input type="submit" class="btn btn-success" value="Update">
                <g:actionSubmit class="btn btn-info pull-right" value="Print" action="printFuelPrices"/>
            </g:form>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">

            <table class="table">
                <thead>
                <tr>
                    <th>Product</th>
                    <th>Description</th>
                    %{--<g:each in="${dtnPrices}" var="row">--}%
                        <g:each in="${dtnPrices[1]?.supplier}" var="supplier">
                            <g:if test="${supplier.name != "TPSI" && supplier.name != "US Oil" && supplier.name != "BUCKEYE" && supplier.name != "Citgo"}">
                                <th>${supplier.name}</th>
                            </g:if>
                            <g:elseif test="${supplier.name == "US Oil"}">
                                %{--<th>US Oil/Fred</th>--}%
                            </g:elseif>
                            <g:elseif test="${supplier.name == "MARA UNB"}">
                                <th>${supplier.name}</th>
                            </g:elseif>
                            <g:elseif test="${supplier.name == "Citgo"}">
                                %{--<th>US Oil/Citgo</th>--}%
                            </g:elseif>
                        </g:each>
                    %{--</g:each>--}%
                    %{--<th>Conoco Contract</th>--}%
                    %{--<th>Conoco</th>--}%
                    %{--<th>Sunoco</th>--}%
                    %{--<th>BP</th>--}%
                    %{--<th>Huguenot</th>--}%
                    %{--<th>TPSI</th>--}%
                </tr>
                </thead>
                <tbody>
                <g:each in="${dtnPrices}" var="row">
                    <tr>
                        <td>
                            <b style="color:black">${row.product}</b>
                        </td>
                        <td>
                            <b style="color:black">${row.description}</b>
                        </td>
                        <g:each in="${row.supplier}" var="supplier">
                            <g:if test="${supplier.name != "TPSI" && supplier.name != "US Oil" && supplier.name != "Citgo" && supplier.name != "BUCKEYE"}">
                                <td>
                                    <b style="color:black">
                                        ${supplier.price}
                                        <g:if test="${supplier.difference?.contains("-")}">
                                            <small class="text-danger"> ${supplier.difference?.indexOf(".") < 0 ? supplier.difference : supplier.difference?.replaceAll("0*\$", "")?.replaceAll("\\.\$", "")}</small>
                                        </g:if>
                                        <g:elseif test="${supplier.difference?.toFloat() == 0 || !supplier.difference}">

                                        </g:elseif>
                                        <g:else>
                                            <small class="text-success"> +${supplier.difference?.toFloat()}</small>
                                        </g:else>
                                    </b>
                                </td>
                            </g:if>
                        </g:each>
                    </tr>
                </g:each>
                </tbody>
            </table>

        </div>
    </div>
</div>

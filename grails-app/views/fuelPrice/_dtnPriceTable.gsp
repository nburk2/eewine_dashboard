<%@ page import="java.math.RoundingMode; java.math.MathContext" %>
<div class="x_panel">
    <div class="x_content">
        <div class="x_title">
            <h2>DTN Prices</h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">

            <table class="table">
                <thead>
                <tr>
                    <th>Product</th>
                    <th>Description</th>
                    <th>Conoco Contract</th>
                    <th>Conoco</th>
                    <th>Sunoco</th>
                    <th>BP</th>
                    <th>Huguenot</th>
                    <th>TPSI</th>
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
                            <td>
                                <b style="color:black">${supplier.price}</b>
                            </td>
                        </g:each>
                    </tr>
                </g:each>
                </tbody>
            </table>

        </div>
    </div>
</div>

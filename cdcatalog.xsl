<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>My CD Collection</h2>
                <table border="1">
                    <tr bgcolor="red">
                        <th>Title</th>
                        <th>Artist</th>
                        <th>Country</th>
                        <th>Company</th>
                        <th>Price</th>
                        <th>Year</th>
                    </tr>
                    <xsl:for-each select="catalog/cd">
                        <tr>
                            <td>
                                <xsl:value-of select="title"/>
                            </td>
                            <td>
                                <xsl:value-of select="artist"/>
                            </td>
                            <td>
                                <xsl:value-of select="country"/>
                            </td>
                            <td>
                                <xsl:value-of select="company"/>
                            </td>
                            <td>
                                <xsl:value-of select="price"/>
                                <xsl:if test="price &lt; 9">
                                    <xsl:apply-templates select="price"/>
                                </xsl:if>
                            </td>
                            <td>
                                <xsl:value-of select="year"/>
                                <xsl:if test="year &gt;= 1995">
                                    <xsl:apply-templates select="year"/>
                                </xsl:if>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="price">
        <img src="https://thumbs.dreamstime.com/b/discount-icon-vector-simple-discount-sign-modern-design-style-web-site-mobile-app-eps-vector-illustration-discount-icon-169793316.jpg"
             width="30px" align="center"></img>
    </xsl:template>

    <xsl:template match="year">
        <img src="data:image/png;base64,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"
             width="25px" align="center"></img>
    </xsl:template>
</xsl:stylesheet>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/defs/taglibs.jsp" %>

<script type="text/javascript">
    //<![CDATA[

    let user = "${encodeUser}";

    /**
     * DOCUMENT READY
     */
    $(document).ready(function () {
        let atob_var = window.atob(user); // Decode
        console.log(atob_var);
        user = JSON.parse(atob_var); // Parse json string to object
        console.log(user);
        // Paint
        $("#userName").html(user.nombre);
        $("#userApell").html(user.apellido);
        $("#userEmail").html(user.email);

        user = btoa(JSON.stringify(user)); // Encode
        saveUser(); // Send
    });


    /**
     * REVISAR O REHACER O NO UTILIZAR
     */
    function saveUser() {
        let formData = new FormData();
        formData.append("json", user);
        $.ajax({
            url : "${ctx}/javaVariosTest.html",
            data : formData,
            processData: false,
            contentType : false,
            type : "POST",
            success : function() {
                console.log("OK");
            },
            error : function() {
                console.log( "Error Saving User Information" );
            }
        });
    }



    function utf8_decode(strData) {

        var tmpArr = []
        var i = 0
        var c1 = 0
        var seqlen = 0

        strData += ''

        while (i < strData.length) {
            c1 = strData.charCodeAt(i) & 0xFF
            seqlen = 0

            // https://en.wikipedia.org/wiki/UTF-8#Codepage_layout
            if (c1 <= 0xBF) {
                c1 = (c1 & 0x7F)
                seqlen = 1
            } else if (c1 <= 0xDF) {
                c1 = (c1 & 0x1F)
                seqlen = 2
            } else if (c1 <= 0xEF) {
                c1 = (c1 & 0x0F)
                seqlen = 3
            } else {
                c1 = (c1 & 0x07)
                seqlen = 4
            }

            for (var ai = 1; ai < seqlen; ++ai) {
                c1 = ((c1 << 0x06) | (strData.charCodeAt(ai + i) & 0x3F))
            }

            if (seqlen === 4) {
                c1 -= 0x10000
                tmpArr.push(String.fromCharCode(0xD800 | ((c1 >> 10) & 0x3FF)))
                tmpArr.push(String.fromCharCode(0xDC00 | (c1 & 0x3FF)))
            } else {
                tmpArr.push(String.fromCharCode(c1))
            }

            i += seqlen
        }

        return tmpArr.join('')
    }


    //]]>
</script>
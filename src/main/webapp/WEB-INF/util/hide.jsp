<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<!-- hide/expand stuff -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    var x = true;
    $(document).ready(function () {
        x = false;
        $("#trigger").click(function () {
            $("#trigger").text(x ? "expand" : "hide");
            $("[id|=tbl]").toggleClass("hide");
            x = !x;
        });
    });
</script>
<style>
    .hide {
        display: none;
    }
</style>
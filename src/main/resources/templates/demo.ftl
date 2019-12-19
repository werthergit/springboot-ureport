<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>HTML报表测试</title>
    <style type="text/css">
        ${htmlReport.getStyle()}
    </style>
</head>
<body>
<!-- 通过一个HTML链接来导出目标报表模版的PDF格式报表 -->
<a href="/ureport/pdf?_u=store-01.ureport.xml">导出PDF格式报表</a>
<a href="/ureport/excel?_u=store-01.ureport.xml">导出excel格式报表</a>
<a href="/chart">跳转图表格式</a>

<p></p>
${htmlReport.getContent()}
</body>
</html>
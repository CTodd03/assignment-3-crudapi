<#macro page title pageStyles="" activePage="">
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${title}</title>
	<link rel="stylesheet" href="/css/site.css">
	${pageStyles}
</head>
<body>
	<nav class="site-nav" aria-label="Main navigation">
		<a class="brand" href="/">HOENN TRAINER REGISTRY</a>
		<div class="links">
			<a href="/" <#if activePage == "home">aria-current="page"</#if>>Home</a>
			<a href="/about" <#if activePage == "about">aria-current="page"</#if>>About</a>
			<a href="/characters/new" <#if activePage == "register">aria-current="page"</#if>>Add TRAINER</a>
		</div>
	</nav>

	<#if success?? && success?has_content>
		<div class="success-message" role="status">${success}</div>
	</#if>

	<#nested>
</body>
</html>
</#macro>

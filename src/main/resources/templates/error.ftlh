<#import "layout.ftlh" as layout>
<#assign pageStyles>
	<style>
		body { color: #24324a; background: #f5f3ff; line-height: 1.6; }
		main {
			width: min(680px, 92%);
			margin: 4rem auto;
			padding: 2rem;
			text-align: center;
			background: white;
			border-radius: 10px;
			box-shadow: 0 2px 8px #b7c8df;
		}
		h1 { margin-top: 0; color: #415dd8; }
		.home-link {
			display: inline-block;
			margin-top: 1rem;
			padding: .7rem 1rem;
			color: white;
			background: #415dd8;
			border-radius: 6px;
			text-decoration: none;
		}
		.home-link:hover, .home-link:focus { background: #3049b8; }
	</style>
</#assign>
<@layout.page title="Character Not Found" pageStyles=pageStyles>
	<main>
		<h1>Character Not Found</h1>
		<p>Sorry, the character you're looking for doesn't exist.</p>
		<p>It may have been removed, or the link may be incorrect.</p>
		<a class="home-link" href="/">Return to the Trainer Registry</a>
	</main>
</@layout.page>

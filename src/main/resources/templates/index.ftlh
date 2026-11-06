<#import "layout.ftlh" as layout>
<#assign pageStyles>
	<style>
		:root {
			--ink: #172033;
			--muted: #64748b;
			--accent: #ed3a3a;
			--accent-dark: #5b21b6;
			--surface: #ffffff;
			--background: #f5f3ff;
		}

		* { box-sizing: border-box; }
		body {
			margin: 0;
			color: var(--ink);
			background: var(--background);
			font-family: Arial, sans-serif;
		}
		header { margin: 0 auto; max-width: 1100px; padding: 4rem 1.5rem 2rem; text-align: center; }
		h1 { font-size: clamp(2.2rem, 5vw, 4rem); margin: 0 0 .75rem; }
		header p { color: var(--muted); font-size: 1.1rem; margin: 0 auto 1.75rem; max-width: 650px; }
		.search { background: var(--surface); border: 2px solid #ddd6fe; border-radius: 999px; font-size: 1rem; max-width: 560px; padding: .9rem 1.25rem; width: 100%; }
		.search-form { display: flex; flex-wrap: wrap; justify-content: center; gap: .75rem; }
		.search-form button { border: 0; border-radius: 999px; padding: .9rem 1.25rem; background: var(--accent); color: white; font-weight: bold; cursor: pointer; }
		main { margin: 0 auto; max-width: 1100px; padding: 1rem 1.5rem 4rem; }
		.gallery { display: grid; gap: 1.5rem; grid-template-columns: repeat(auto-fit, minmax(190px, 1fr)); }
		.card-link { color: inherit; text-decoration: none; }
		.card { background: var(--surface); border-radius: 18px; box-shadow: 0 10px 25px #312e8118; overflow: hidden; transition: transform .2s; }
		.card:hover { transform: translateY(-5px); }
		.card img { display: block; height: 220px; object-fit: cover; width: 100%; }
		.card-content { padding: 1.1rem; }
		.card h2 { font-size: 1.25rem; margin: 0 0 .35rem; }
		.role { color: var(--accent); font-size: .85rem; font-weight: bold; letter-spacing: .04em; text-transform: uppercase; }
		.card p { color: var(--muted); line-height: 1.5; margin: .65rem 0 0; }
		footer { color: var(--muted); padding: 1rem; text-align: center; }
	</style>
</#assign>
<@layout.page title="TRAINER REGISTRY" pageStyles=pageStyles activePage="home">
	<header>
		<h1>HOENN REGION TRAINER REGISTRY</h1>
		<p>A database of TRAINERS from the HOENN region.</p>
		<form class="search-form" action="/" method="get">
			<input class="search" type="search" name="name" value="${(name!'')?html}" placeholder="Search by name..." aria-label="Search by name">
			<input class="search" type="search" name="category" value="${(category!'')?html}" placeholder="Filter by category..." aria-label="Filter by category">
			<button type="submit">Search</button>
		</form>
	</header>

	<main>
		<section class="gallery" aria-label="Character gallery">
			<#list characters as character>
				<a class="card-link" href="/characters/${character.characterId}">
					<article class="card">
						<img src="/detailsimage.png" alt="${character.name?html}">
						<div class="card-content">
							<div class="role">${character.type?html}</div>
							<h2>${character.name?html}</h2>
							<p>${character.description?html}</p>
						</div>
					</article>
				</a>
			<#else>
				<p>No characters match your search.</p>
			</#list>
		</section>
	</main>
	<footer>&copy; 2002 GAME FREAK</footer>
</@layout.page>

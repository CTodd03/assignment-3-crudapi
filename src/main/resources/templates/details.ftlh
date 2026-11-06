<#import "layout.ftlh" as layout>
<#assign pageStyles>
	<style>
		:root {
			--ink: #20243a;
			--accent: #6c4ab6;
			--light: #f5f3ff;
			--white: #ffffff;
		}

		* { box-sizing: border-box; }

		body {
			margin: 0;
			color: var(--ink);
			background: var(--light);
			font-family: Arial, sans-serif;
			line-height: 1.6;
		}

		main {
			display: grid;
			grid-template-columns: minmax(240px, 420px) 1fr;
			gap: 3rem;
			align-items: center;
			max-width: 1100px;
			margin: 3rem auto;
			padding: 0 6%;
		}

		.character-image {
			width: 100%;
			max-height: 560px;
			object-fit: contain;
			border-radius: 14px;
			background: var(--white);
			box-shadow: 0 8px 24px #20243a22;
		}

		h2 { margin-top: 0; color: var(--accent); font-size: 2.3rem; }
		h3 { margin-bottom: .35rem; color: var(--accent); }
		.intro { font-size: 1.1rem; }

		.details-list {
			display: grid;
			grid-template-columns: repeat(2, minmax(120px, 1fr));
			gap: 1rem;
			margin-top: 1.5rem;
		}

		.details-list div {
			padding: 1rem;
			background: var(--white);
			border-left: 4px solid var(--accent);
			border-radius: 6px;
		}

		footer { padding: 1.5rem; text-align: center; color: #555; }

		@media (max-width: 700px) {
			main { display: block; }
			main { margin-top: 2rem; }
			.character-image { margin-bottom: 2rem; }
		}
	</style>
</#assign>
<@layout.page title="Character Details" pageStyles=pageStyles activePage="details">
	<main>
		<img class="character-image" src="/detailsimage.png" alt="${character.name?html}">
		<section>
			<h2>${character.name?html}</h2>
			<p class="intro">${character.description?html}</p>
			<h3>Category</h3>
			<p>${character.type?html}</p>

			<h3>Strategy</h3>
			<p>${character.strategy?html}</p>

			<div class="details-actions">
				<a href="/characters/${character.characterId}/edit">Edit</a>
				<form action="/characters/${character.characterId}/delete" method="post">
					<button type="submit">Delete</button>
				</form>
			</div>
		</section>
	</main>
	<footer>&copy; 2002 GAME FREAK</footer>
</@layout.page>

<#import "layout.ftlh" as layout>
<#assign pageStyles>
	<style>
		:root { color-scheme: light; font-family: Arial, sans-serif; }
		* { box-sizing: border-box; }
		body { margin: 0; color: #24324a; background: #f5f3ff; line-height: 1.6; }
		header { padding: 2rem 1rem 1rem; text-align: center; background: #415dd8; color: white; }
		main { width: min(900px, 92%); margin: 2rem auto; }
		.intro { display: flex; align-items: center; gap: 2rem; padding: 1.5rem; background: white; border-radius: 10px; box-shadow: 0 2px 8px #b7c8df; }
		.intro img { width: min(280px, 100%); border-radius: 8px; }
		h1, h2 { line-height: 1.2; }
		footer { margin-top: 3rem; padding: 1rem; text-align: center; color: #52627a; }
		@media (max-width: 650px) { .intro { flex-direction: column; align-items: stretch; } }
	</style>
</#assign>
<@layout.page title="About Hoenn Trainer Registry" pageStyles=pageStyles activePage="about">
	<header>
		<h1>About the Hoenn Trainer Registry</h1>
		<p>A simple fan-made reference for exploring Trainers from the Hoenn region.</p>
	</header>

	<main>
		<section class="intro">
			<img src="/HoennRS.png" alt="Hoenn region artwork from Ruby and Sapphire">
			<div>
				<h2>Why this site was created</h2>
				<p>Because I was assigned to, duh!!</p>
				<p>I chose to use Pokémon RSE characters because I'm replaying Emerald right now.</p>
			</div>
		</section>
	</main>
	<footer>YEAH!!!!!!!</footer>
</@layout.page>

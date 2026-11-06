<#import "layout.ftlh" as layout>
<#assign pageStyles>
	<style>
		main {
			max-width: 650px;
			margin: 2rem auto;
			padding: 2rem;
			background: #fff;
			border-radius: 8px;
			box-shadow: 0 2px 8px #0002;
		}
		label { display: block; margin-top: 1rem; font-weight: bold; }
		input, textarea {
			width: 100%;
			margin-top: .4rem;
			padding: .75rem;
			border: 1px solid #aaa;
			border-radius: 4px;
			font: inherit;
		}
		textarea { min-height: 120px; resize: vertical; }
		button {
			margin-top: 1.5rem;
			padding: .75rem 1.25rem;
			border: 0;
			border-radius: 4px;
			color: #fff;
			background: #2563eb;
			font-weight: bold;
			cursor: pointer;
		}
		.validation-errors { color: #b91c1c; }
	</style>
</#assign>
<@layout.page title="TRAINER Information" pageStyles=pageStyles activePage="register">
	<main>
		<h1><#if character.characterId??>Edit<#else>Add</#if> a TRAINER</h1>
		<#if validationErrors?? && validationErrors?has_content>
			<div class="validation-errors" role="alert">
				<p>Please correct the following:</p>
				<ul>
					<#list validationErrors as error>
						<li>${error.defaultMessage}</li>
					</#list>
				</ul>
			</div>
		</#if>
		<form method="post" action="<#if character.characterId??>/characters/${character.characterId}<#else>/characters</#if>">
			<label for="name">Name</label>
			<input type="text" id="name" name="name" value="${character.name!''}" required>

			<label for="description">Description</label>
			<textarea id="description" name="description" required>${character.description!''}</textarea>

			<label for="type">Category</label>
			<input type="text" id="type" name="type" value="${character.type!''}" required>

			<label for="strategy">Strategy</label>
			<textarea id="strategy" name="strategy" required>${character.strategy!''}</textarea>

			<button type="submit"><#if character.characterId??>Save Changes<#else>Add TRAINER</#if></button>
		</form>
	</main>
</@layout.page>

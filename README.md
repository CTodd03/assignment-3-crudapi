# assignment-3-crudapi
# Pokémon Trainer API

A RESTful CRUD API for fictional characters from the Assignment 2 website. In this case, it's Pokémon Trainers. (Pokémon is owned by The Pokémon Company. I do not claim ownership.)

## Entity Attributes

- characterId
- Name
- Description
- Type (The type of Pokémon they use)
- Strategy - A short blurb from the character i.e. Trainer's Eyes from Gen 3.
- Image URL - A URL or static-resource path for the character image.

## API Endpoints

Base path: `/api/characters`

| Method | Path | Description | Success |
|--------|------|-------------|---------|
| GET | `/api/characters` | List all Trainers | 200 |
| GET | `/api/characters/{id}` | Get one Trainer by ID | 200 |
| POST | `/api/characters` | Add Trainer | 201 |
| PUT | `/api/characters/{id}` | Replace a Trainer's fields | 200 |
| DELETE | `/api/characters/{id}` | Delete a Trainer | 204 |
| GET | `/api/characters?type=` | Filter by one category | 200 |
| GET | `/api/characters?name=` | Search by name (partial, case-insensitive) | 200 |

### Example request

```http
POST /api/plants
Content-Type: application/json

{
  "description": "TRAINER on ROUTE 109.",
  "name": "TUBER LOLA",
  "strategy": "I'm going to try hard!",
  "type": "WATER",
  "imageUrl": "/lola_image.png"
}
```

### Website Routes

| Route | Description |
| --- | --- |
| [`/`](http://localhost:8080/) | Character gallery displaying the available characters. |
| [`/?name=Steven&category=Steel`](http://localhost:8080/?name=Steven&category=Steel) | Search and filter characters by name and category. Use a category value that matches your data. |
| [`/characters/1`](http://localhost:8080/characters/1) | Details page for the character with ID `1`. |
| [`/about`](http://localhost:8080/about) | About page with information about the website. |
| [`/characters/new`](http://localhost:8080/characters/new) | Form for adding a character. |
| [`/characters/1/edit`](http://localhost:8080/characters/1/edit) | Form for editing the character with ID `1`. |
| [`/characters/999999`](http://localhost:8080/characters/999999) | Not-found page when the requested character ID does not exist (assuming `999999` is unused). |


### Link to deployment on Render

https://assignment-3-crudapi.onrender.com/

Use api/characters for API.

NOTICE: Free Render services sleep when idle, so the first request can take up to a minute.

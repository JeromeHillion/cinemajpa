import React, { Component } from 'react';
import './App.css';
import MovieRow from './MovieRow.js'
import $ from 'jquery'


class App extends Component {

    constructor(props){
        super(props)
        this.state = {}
        /*console.log("C'est mon initialiseur")*/

  /*      const movies =[
            {id : 0, poster_src: "https://image.tmdb.org/t/p/w185_and_h278_bestv2/hSfuKPtyEryeFzapZ8UgZd4aESu.jpg", title : "Avengers : Infinity War", overview : "Les Avengers et leurs alliés devront être prêts" +
                    " à tout sacrifier pour neutraliser le redoutable Thanos avant que son attaque éclair ne " +
                    "conduise à la destruction complète de l’univers. " },
            {id : 1, poster_src: "https://image.tmdb.org/t/p/w185_and_h278_bestv2/s9UPgyelWtEqjS3HT3TUuHU9BHU.jpg", title : "The Avengers", overview : "Lorsque Nick Fury, le directeur du S.H.I.E.L.D., " +
                    "l'organisation qui préserve la paix au plan mondial, cherche à former une équipe de choc pour" +
                    " empêcher la destruction du monde, Iron Man, Hulk, Thor, Captain America, Hawkeye et" +
                    " Black Widow répondent présents.\n" +
                    "Les Avengers ont beau constituer la plus fantastique des équipes, il leur reste encore à " +
                    "apprendre à travailler ensemble, et non les uns contre les autres, d'autant que le redoutable" +
                    " Loki a réussi à accéder au Cube Cosmique et à son pouvoir illimité... "}
        ]

            var moviesRows = []
        movies.forEach((movie) => {
            console.log(movie.id)
            console.log(movie.title)
            console.log(movie.overview)

            const movieRow = <MovieRow movie={movie}/>
            moviesRows.push(movieRow)
        })

        this.state = {rows : moviesRows}*/
  this.performSearch("Naruto")
    }

    performSearch (searchTerm){
        console.log("Effectuer une recherche en utilisant moviedb")
        const urlString = "https://api.themoviedb.org/3/search/movie?api_key=ddec886742429cd922ebad0010e96c2d&language=fr-FR&page=minimum%3A%201%20maximum%3A%201000%20default%3A%201&include_adult=false&region=pattern%3A%20%5E%5BA-Z%5D%7B2%7D%24&query=" +searchTerm

        $.ajax({
            url : urlString,
            success : (searchResults) => {
                console.log("Données récupérées avec succès")
                /*console.log(searchResults)*/
                const results = searchResults.results

                var movieRows = []
                /*console.log(results[0])*/
                results.forEach((movie) => {
                    movie.poster_src = "https://image.tmdb.org/t/p/w185" + movie.poster_path
                    /*console.log(movie.poster_path)*/
                    const movieRow = <MovieRow key={movie.id} movie={movie}/>
                    movieRows.push(movieRow)
                })

                this.setState({rows : movieRows})
            },

            error : (xhr, status, err) => {
                console.error("Impossible de récupérer les données")
            }
        })
    }
  render() {
      return(
      <div>
          <table className="titleBar">
              <tbody>
              <tr>
                  <td>
                      <img width="50" src="tmdb.png" alt="app icon"/>
                  </td>
                  <td width="8"/>
                  <td>
                      <h1>Recherche MoviesDB</h1>
                  </td>
              </tr>
              </tbody>
          </table>

          <input style={{
              fontSize: 24,
              display: "block",
              width:"99%",
              paddingTop : 8,
              paddingBottom:8,
              paddingLeft:16
          }} placeholder="Entrer le nom du film à rechercher "/>

          {this.state.rows}


      </div>
    );
  }
}
export default App;


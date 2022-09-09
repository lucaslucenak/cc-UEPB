import React from 'react'
import axios from 'axios'

import './stylesListProjects.css';

export default class ListProjects extends React.Component {
  state = {
    projetos: []
  }

  componentDidMount() {
    axios.get('https://immense-sands-97611.herokuapp.com/api/v1/projects')
      .then(res => {
        const projetos = res.data
        console.log(res.data)
        this.setState({ projetos })
      })
  }

  render() {
    return (
      <>
        <h1 align="center" className="margin">Lista dos Projetos</h1>
        <table className="table">
          <tr className="thead-dark">
            <th scope="col">Users</th>
            <th scope="col">Function</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
          </tr>
          {this.state.projetos.map(projeto =>
            <tr className="bottom">
              <td key={projeto._id}>{projeto.users[0].username}</td>
              <td key={projeto._id}>{projeto.users[0].function}</td>
              <td key={projeto._id}>{projeto.name}</td>
              <td key={projeto._id}>{projeto.description}</td>
            </tr>)}
        </table>

      </>
    )
  }
}
import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  state = {
    isLoading: true,
    datasets: []
  };

  async componentDidMount() {
    const response = await fetch('/api/datasets');
    const body =  await response.json();
    this.setState({ datasets: body, isLoading: false});
  }

  render() {
    const {datasets, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className = "App-intro">
            <h2>Dataset List</h2>
            {datasets.map(dataset =>
              <div key={dataset.id}>
                {dataset.name}
              </div>
            )}
          </div>
        </header>
      </div>
    );
  }
}

export default App;



            var container = document.getElementById('usecase');
            var data = {
                nodes: nodes,
                edges: edges
            };
            network = new vis.Network(container, data, options);
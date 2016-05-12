

            var container = document.getElementById('usecase');
            var data = {
                nodes: nodes,
                edges: edges
            };
            network = new vis.Network(container, data, options);
            document.getElementsByClassName("vis-configuration-wrapper")[0].style.display = 'none';
            setTimeout(function() { removePhysicsPanel(); }, 10);
            setTimeout(function() {
                document.getElementsByClassName('vis-configuration vis-config-checkbox')[0].click();
            }, 8);

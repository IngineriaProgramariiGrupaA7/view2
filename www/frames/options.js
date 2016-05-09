            var options = {
                groups: {
                    actors: {
                        shape: 'icon',
                        icon: {face: 'Ionicons', code: '\uc6c3', color: 'black', size: 60},
                    },
                    actions: {
                    borderWidth: 2,
                    borderWidthSelected: 3
                    }
                },
                nodes: {
                    font: {face: 'Times New Roman', size: 20},
                    color: {
                        background: 'white',
                        border: 'black',
                        highlight: {
                            border: 'black',
                            background: 'white'
                        },
                        hover: {
                            border: 'black',
                            background: 'white'
                        }
                    }
                },
                edges: {
                    width: 3,
                    selectionWidth: 0,
                    labelHighlightBold: false,
                    smooth: false,
                    color: {inherit: false},
                    arrowStrikethrough: false,
                    arrows: {
                        to: {enabled: false, scaleFactor: 1},
                        from: {enabled: false, scaleFactor: 1}
                    },
                    font: {size: 20},
                    length: 600
                },
                physics: {
                    enabled: false
                }
            };
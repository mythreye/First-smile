<script
	src="https://jssors8.azureedge.net/script/jssor.slider-27.5.0.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	jssor_1_slider_init = function() {

		var jssor_1_SlideshowTransitions = [ {
			$Duration : 800,
			x : -0.3,
			$During : {
				$Left : [ 0.3, 0.7 ]
			},
			$Easing : {
				$Left : $Jease$.$InCubic,
				$Opacity : $Jease$.$Linear
			},
			$Opacity : 2
		}, {
			$Duration : 800,
			x : 0.3,
			$SlideOut : true,
			$Easing : {
				$Left : $Jease$.$InCubic,
				$Opacity : $Jease$.$Linear
			},
			$Opacity : 2
		}, {
			$Duration : 1200,
			x : 0.6,
			y : -0.6,
			$Zoom : 1,
			$Easing : {
				$Left : $Jease$.$InCubic,
				$Top : $Jease$.$InCubic,
				$Zoom : $Jease$.$InCubic,
				$Opacity : $Jease$.$OutQuad
			},
			$Opacity : 2
		}, {
			$Duration : 1000,
			x : 0.2,
			$Delay : 20,
			$Cols : 16,
			$Formation : $JssorSlideshowFormations$.$FormationStraightStairs,
			$Assembly : 260,
			$Easing : {
				$Left : $Jease$.$InOutExpo,
				$Opacity : $Jease$.$InOutQuad
			},
			$Opacity : 2,
			$Outside : true,
			$Round : {
				$Top : 0.5
			}
		}, {
			$Duration : 1200,
			x : 0.2,
			y : -0.1,
			$Delay : 40,
			$Cols : 10,
			$Rows : 5,
			$Opacity : 2,
			$Clip : 15,
			$During : {
				$Left : [ 0.3, 0.7 ],
				$Top : [ 0.3, 0.7 ]
			},
			$ChessMode : {
				$Column : 3,
				$Row : 3
			},
			$Easing : {
				$Left : $Jease$.$InWave,
				$Top : $Jease$.$InWave,
				$Clip : $Jease$.$OutQuad
			},
			$Round : {
				$Left : 1.3,
				$Top : 2.5
			}
		}, {
			$Duration : 1500,
			x : 0.2,
			y : -0.1,
			$Delay : 20,
			$Cols : 10,
			$Rows : 5,
			$Opacity : 2,
			$Clip : 15,
			$During : {
				$Left : [ 0.3, 0.7 ],
				$Top : [ 0.3, 0.7 ]
			},
			$SlideOut : true,
			$Formation : $JssorSlideshowFormations$.$FormationSwirl,
			$Assembly : 260,
			$Easing : {
				$Left : $Jease$.$InWave,
				$Top : $Jease$.$InWave,
				$Clip : $Jease$.$OutQuad
			},
			$Round : {
				$Left : 0.8,
				$Top : 2.5
			}
		}, {
			$Duration : 1200,
			x : 0.3,
			y : -0.3,
			$Delay : 20,
			$Cols : 10,
			$Rows : 5,
			$Opacity : 2,
			$Clip : 15,
			$During : {
				$Left : [ 0.2, 0.8 ],
				$Top : [ 0.2, 0.8 ]
			},
			$Formation : $JssorSlideshowFormations$.$FormationZigZag,
			$Assembly : 260,
			$Easing : {
				$Left : $Jease$.$InJump,
				$Top : $Jease$.$InJump,
				$Clip : $Jease$.$Swing
			},
			$Round : {
				$Left : 0.8,
				$Top : 0.8
			}
		}, {
			$Duration : 1800,
			x : 0.2,
			y : -0.1,
			$Delay : 150,
			$Cols : 12,
			$Opacity : 2,
			$SlideOut : true,
			$Formation : $JssorSlideshowFormations$.$FormationStraightStairs,
			$Assembly : 260,
			$Easing : {
				$Left : $Jease$.$Linear,
				$Top : $Jease$.$OutWave,
				$Opacity : $Jease$.$Linear
			},
			$Round : {
				$Top : 2
			}
		}, {
			$Duration : 1500,
			x : 1,
			y : 0.5,
			$Delay : 60,
			$Cols : 10,
			$Rows : 5,
			$Opacity : 2,
			$SlideOut : true,
			$Formation : $JssorSlideshowFormations$.$FormationRectangle,
			$Assembly : 260,
			$Easing : {
				$Left : $Jease$.$Linear,
				$Top : $Jease$.$OutWave,
				$Opacity : $Jease$.$Linear
			},
			$Round : {
				$Top : 1.5
			}
		}, {
			$Duration : 1500,
			x : -1,
			y : 0.5,
			$Delay : 800,
			$Cols : 10,
			$Rows : 5,
			$Opacity : 2,
			$SlideOut : true,
			$Reverse : true,
			$Formation : $JssorSlideshowFormations$.$FormationRectangle,
			$Assembly : 260,
			$Easing : {
				$Left : $Jease$.$Linear,
				$Top : $Jease$.$OutJump
			},
			$Round : {
				$Top : 1.5
			}
		} ];

		var jssor_1_options = {
			$AutoPlay : 1,
			$SlideshowOptions : {
				$Class : $JssorSlideshowRunner$,
				$Transitions : jssor_1_SlideshowTransitions
			},
			$ArrowNavigatorOptions : {
				$Class : $JssorArrowNavigator$
			},
			$ThumbnailNavigatorOptions : {
				$Class : $JssorThumbnailNavigator$,
				$Orientation : 2,
				$NoDrag : true
			}
		};

		var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

		/*#region responsive code begin*/

		var MAX_WIDTH = 980;

		function ScaleSlider() {
			var containerElement = jssor_1_slider.$Elmt.parentNode;
			var containerWidth = containerElement.clientWidth;

			if (containerWidth) {

				var expectedWidth = Math.min(MAX_WIDTH || containerWidth,
						containerWidth);

				jssor_1_slider.$ScaleWidth(expectedWidth);
			} else {
				window.setTimeout(ScaleSlider, 30);
			}
		}

		ScaleSlider();

		$Jssor$.$AddEvent(window, "load", ScaleSlider);
		$Jssor$.$AddEvent(window, "resize", ScaleSlider);
		$Jssor$.$AddEvent(window, "orientationchange", ScaleSlider);
		/*#endregion responsive code end*/
	};
</script>
<script>
  $(document).ready(function() {
    $('#myCarousel').carousel({
	    interval: 10000
	})
});
    </script>
<style>
/*jssor slider loading skin spin css*/
.jssorl-009-spin img {
	animation-name: jssorl-009-spin;
	animation-duration: 1.6s;
	animation-iteration-count: infinite;
	animation-timing-function: linear;
}

@
keyframes jssorl-009-spin {from { transform:rotate(0deg);
	
}

to {
	transform: rotate(360deg);
}

}
.jssora061 {
	display: block;
	position: absolute;
	cursor: pointer;
}

.jssora061 .a {
	fill: none;
	stroke: #fff;
	stroke-width: 360;
	stroke-linecap: round;
}

.jssora061:hover {
	opacity: .8;
}

.jssora061.jssora061dn {
	opacity: .5;
}

.jssora061.jssora061ds {
	opacity: .3;
	pointer-events: none;
} 

 /*start productslider*/
.whitecolor{
    background-color: #fff;
      box-shadow: 0px 1px 1px 0px rgba(0,0,0,0.2);
    height: 310px;
    padding-top: 40px;
}
.whitecolor h4{
    line-height: 25px;
}
.thumbnail:hover{
    margin: 0px -4px 0px -4px; 
    border: 1px solid #ebebeb;
     -webkit-transition: margin 2s; /* Safari */
    transition: margin 1s;
}
.thumbnail{
    border: none;
}
.productslider p{
    font-size: 16px;
    font-weight: bold;
    color: #817e7e
}
.addcart{
    border: none;
    background-color: #e42d05;
    color: #fff;
    font-weight: bold;
    padding: 10px 15px 10px 15px;
} 
.addcart:hover{
      box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}
.productslider{
    padding: 20px 0 20px 0;
}
.carousel-control.right {
    background-image: none;
}
.carousel-control.left {
    background-image: none;
}
.fa-caret-left,.fa-caret-right{
    padding:10px 10px 10px 10px;
    background-color: #fff;
    border: 1px solid #e5e5e5;
}
.fa-caret-left{
    margin-left: -78px;
}
.fa-caret-right{
    margin-right: -78px;
}
/*end productslider*/

</style>
<div id="jssor_1"
	style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 980px; height: 380px; overflow: hidden; visibility: hidden;">
	<!-- Loading Screen -->
	<div data-u="loading" class="jssorl-009-spin"
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; text-align: center; background-color: rgba(0, 0, 0, 0.7);">
		<img
			style="margin-top: -19px; position: relative; top: 50%; width: 38px; height: 38px;"
			src="//jssorcdn7.azureedge.net/theme/svg/loading/static-svg/spin.svg" />
	</div>
	<div data-u="slides"
		style="cursor: default; position: relative; top: 0px; left: 0px; width: 980px; height: 380px; overflow: hidden;">
		<div>
			<img data-u="image"
				src="resources/images/carousel1.jpg" />
			<div u="thumb">Slide Description 001</div>
		</div>
		<div>
			<img data-u="image"
				src="resources/images/carousel2.jpg" />
			<div u="thumb">Slide Description 002</div>
		</div>
		<div>
			<img data-u="image"
				src="resources/images/carousel3.jpg" />
			<div u="thumb">Slide Description 003</div>
		</div>

	</div>
	<!-- Thumbnail Navigator -->
	<div u="thumbnavigator"
		style="position: absolute; bottom: 0px; left: 0px; width: 980px; height: 50px; color: #FFF; overflow: hidden; cursor: default; background-color: rgba(0, 0, 0, .5);">
		<div u="slides">
			<div u="prototype"
				style="position: absolute; top: 0; left: 0; width: 980px; height: 50px;">
				<div u="thumbnailtemplate"
					style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; font-family: arial, helvetica, verdana; font-weight: normal; line-height: 50px; font-size: 16px; padding-left: 10px; box-sizing: border-box;"></div>
			</div>
		</div>
	</div>
	<!-- Arrow Navigator -->
	<div data-u="arrowleft" class="jssora061"
		style="width: 55px; height: 55px; top: 0px; left: 25px;"
		data-autocenter="2" data-scale="0.75" data-scale-left="0.75">
		<svg viewbox="0 0 16000 16000"
			style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;">
                <path class="a"
				d="M11949,1919L5964.9,7771.7c-127.9,125.5-127.9,329.1,0,454.9L11949,14079"></path>
            </svg>
	</div>
	<div data-u="arrowright" class="jssora061"
		style="width: 55px; height: 55px; top: 0px; right: 25px;"
		data-autocenter="2" data-scale="0.75" data-scale-right="0.75">
		<svg viewbox="0 0 16000 16000"
			style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;">
                <path class="a"
				d="M5869,1919l5984.1,5852.7c127.9,125.5,127.9,329.1,0,454.9L5869,14079"></path>
            </svg>
	</div>
</div>
<script type="text/javascript">
	jssor_1_slider_init();
</script>


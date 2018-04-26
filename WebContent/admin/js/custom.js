// JavaScript Document

jQuery(document).ready(function(){ 

	// ---- Smooth scrolling (courtesy of - http://blog.medianotions.de/en/articles/2009/smoothscroll-for-jquery) ---- //
	
	jQuery('a[href*=#header]').click(function() {

		// skip SmoothScroll on links inside sliders or scroll boxes also using anchors or if there is a javascript call
		if(jQuery(this).parent().hasClass('scrollable_navigation') || jQuery(this).attr('href').indexOf('javascript')>-1) return;

		// duration in ms
		var duration=1000;

		// easing values: swing | linear
		var easing='swing';

		// get / set parameters
		var newHash=this.hash;
		var oldLocation=window.location.href.replace(window.location.hash, '');
		var newLocation=this;

		// make sure it's the same location		
		if(oldLocation+newHash==newLocation)
		{
			// get target
			var target=jQuery(this.hash+', a[name='+this.hash.slice(1)+']').offset().top;

			// adjust target for anchors near the bottom of the page
			if(target > jQuery(document).height()-jQuery(window).height()) target=jQuery(document).height()-jQuery(window).height();			

			// set selector
			if(jQuery.browser.safari) var animationSelector='body:not(:animated)';
			else var animationSelector='html:not(:animated)';

			// animate to target and set the hash to the window.location after the animation
			jQuery(animationSelector).animate({ scrollTop: target }, duration, easing, function() {

				// add new hash to the browser location
				window.location.href=newLocation;
			});

			// cancel default click action
			return false;
		}
	});
	
	// ---- Slider ---- //
	jQuery(window).load(function() {

		jQuery('#slider').nivoSlider({
			effect: 'fade', // Specify sets like: 'fold,fade,sliceDown'
			animSpeed: 500, // Slide transition speed
			pauseTime: 8000, // How long each slide will show
			startSlide: 0, // Set starting Slide (0 index)
			directionNav: true, // Next & Prev navigation
			directionNavHide: false, // Only show on hover
			controlNav: false, // 1,2,3... navigation
			controlNavThumbs: false, // Use thumbnails for Control Nav
			controlNavThumbsFromRel: false, // Use image rel for thumbs
			controlNavThumbsSearch: '.jpg', // Replace this with...
			controlNavThumbsReplace: '_thumb.jpg', // ...this in thumb Image src
			keyboardNav: true, // Use left & right arrows
			pauseOnHover: true, // Stop animation while hovering
			manualAdvance: false, // Force manual transitions
			captionOpacity: 0.8, // Universal caption opacity
			prevText: 'Prev', // Prev directionNav text
			nextText: 'Next', // Next directionNav text
			randomStart: false, // Start on a random slide
			beforeChange: function(){}, // Triggers before a slide transition
			afterChange: function(){}, // Triggers after a slide transition
			slideshowEnd: function(){}, // Triggers after all slides have been shown
			lastSlide: function(){}, // Triggers when last slide is shown
			afterLoad: function(){} // Triggers when slider has loaded
		});
		
    });
	
	// ---- Fancybox ---- //
	
	jQuery("a.single_image").fancybox();
	
	function fnOverlay() {
		jQuery('a.single_image').hover( function() {
			jQuery(this).find('.overlay').fadeIn(150);
		}, function() {
			jQuery(this).find('.overlay').fadeOut(150);
		});
	}
	
	fnOverlay();
	
	//---- Testimonial Rotator ----//

	function rotateTestimonial() {
		jQuery('#testimonials').cycle({
        	fx: 'scrollRight', // choose your transition type, ex: fade, scrollUp, scrollRight, shuffle
			speed: 300,
		    pause:  1, // pauses the slideshow on mouseover
			timeout:  15000, 
			cleartypeNoBg: true
		});
	}
	rotateTestimonial();

	//---- Contact Form Slider ----//
	
  	function contactSlider() {
		jQuery("#signup").click(function(){
			jQuery("#signup-form-container").slideDown("slow");
			jQuery("#close").click(function(){
				jQuery("#signup-form-container").slideUp("fast");
			});
		});
	}
	contactSlider();


}); 
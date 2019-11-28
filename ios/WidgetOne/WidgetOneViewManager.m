//
//  WidgetOneViewManager.m
//  NativeComp
//
//  Created by adrian.hartanto on 26/11/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "WidgetOneViewManager.h"
#import "WidgetOneViewController.h"
#import <React/RCTShadowView.h>
#import <React/RCTUIManager.h>

@interface WidgetOneViewManager ()
@property (strong, nonatomic) WidgetOneViewController *widgetVC;
@property (strong, nonatomic) RCTShadowView *shadowView;
@end

@implementation WidgetOneViewManager

RCT_EXPORT_MODULE(WidgetOne)

- (UIView *)view {
  _widgetVC = [[WidgetOneViewController alloc] initWithVM: self];

  return _widgetVC.view;
}

- (RCTShadowView *)shadowView {
  _shadowView = [super shadowView];
  
  return _shadowView;
}

+ (BOOL)requiresMainQueueSetup {
  return NO;
}

- (void)setIntrinsicContentSize:(CGSize)size {
  NSNumber *reactTag = _shadowView.reactTag;
  UIView *view = [self.bridge.uiManager viewForReactTag:reactTag];
  [self.bridge.uiManager setIntrinsicContentSize:size forView:view];
}

- (dispatch_queue_t)methodQueue {
  return dispatch_get_main_queue();
}

@end
